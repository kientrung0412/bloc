package com.bloc.intellij_generator_plugin.generator.bloc

import com.bloc.intellij_generator_plugin.intention_action.toLowerSnakeCase
import com.bloc.intellij_generator_plugin.intention_action.toUpperCamelCase
import com.google.common.io.CharStreams
import org.apache.commons.lang.text.StrSubstitutor
import java.io.InputStreamReader
import java.lang.RuntimeException

abstract class BlocGenerator(private val name: String,
                             templateName: String) {
    //templateName tên file mẫu

    private val TEMPLATE_BLOC_PASCAL_CASE = "bloc_pascal_case"
    private val TEMPLATE_BLOC_SNAKE_CASE = "bloc_snake_case"

    private val templateString: String
    private val templateValues: MutableMap<String, String>

    init {
        templateValues = mutableMapOf(
            TEMPLATE_BLOC_PASCAL_CASE to pascalCase(),
            TEMPLATE_BLOC_SNAKE_CASE to snakeCase()
        )
        try {
            val resource = "/templates/bloc/$templateName.dart.template"
            val resourceAsStream = BlocGenerator::class.java.getResourceAsStream(resource)
            templateString = CharStreams.toString(InputStreamReader(resourceAsStream, Charsets.UTF_8))
        } catch (e: Exception) {
            throw RuntimeException(e)
        }
    }

    //Tên file được gen ra
    abstract fun fileName(): String

    fun generate(): String {
        val substitutor = StrSubstitutor(templateValues)
        return substitutor.replace(templateString)
    }

    fun pascalCase(): String = name.toUpperCamelCase().replace("Bloc", "")

    fun snakeCase() = name.toLowerSnakeCase().replace("_bloc", "")

    fun fileExtension() = "dart"

}