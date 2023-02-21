package com.bloc.intellij_generator_plugin.action

import com.bloc.intellij_generator_plugin.generator.cubit.CubitGenerator
import com.bloc.intellij_generator_plugin.generator.cubit.CubitGeneratorFactory
import com.intellij.lang.java.JavaLanguage
import com.intellij.openapi.actionSystem.*
import com.intellij.openapi.application.ApplicationManager
import com.intellij.openapi.command.CommandProcessor
import com.intellij.openapi.project.Project
import com.intellij.psi.PsiDirectory
import com.intellij.psi.PsiDocumentManager
import com.intellij.psi.PsiFileFactory

class GenerateDartClassAction : AnAction(), GenerateBlocDialog.Listener {

    private lateinit var dataContext: DataContext

    override fun actionPerformed(e: AnActionEvent?) {
        val dialog = GenerateDartClassDialog(this)
        dialog.show()
    }

    override fun onGenerateBlocClicked(blocName: String?, useStateful: Boolean) {
        blocName?.let { name ->
            val generators = CubitGeneratorFactory.getCubitGenerators(name, useStateful)
            generate(generators)
        }
    }

    private fun generate(mainSourceGenerators: List<CubitGenerator>) {
        val project = CommonDataKeys.PROJECT.getData(dataContext)
        val view = LangDataKeys.IDE_VIEW.getData(dataContext)
        val directory = view?.orChooseDirectory
        ApplicationManager.getApplication().runWriteAction {
            CommandProcessor.getInstance().executeCommand(
                project,
                {
                    mainSourceGenerators.forEach { createSourceFile(project!!, it, directory!!) }
                },
                "Generate a new class dart",
                null
            )
        }
    }

    private fun createSourceFile(project: Project, generator: CubitGenerator, directory: PsiDirectory) {
        val fileName = generator.fileName()
        val existingPsiFile = directory.findFile(fileName)
        if (existingPsiFile != null) {
            val document = PsiDocumentManager.getInstance(project).getDocument(existingPsiFile)
            document?.insertString(document.textLength, "\n" + generator.generate())
            return
        }
        val psiFile = PsiFileFactory.getInstance(project)
            .createFileFromText(fileName, JavaLanguage.INSTANCE, generator.generate())
        directory.add(psiFile)
    }
}