package com.bloc.intellij_generator_plugin.generator.components.bloc

import com.bloc.intellij_generator_plugin.generator.bloc.BlocGenerator

class ExportGenerator(
    name: String
) : BlocGenerator(name, templateName = "bloc_export") {
    override fun fileName() = "${snakeCase()}.${fileExtension()}"
}