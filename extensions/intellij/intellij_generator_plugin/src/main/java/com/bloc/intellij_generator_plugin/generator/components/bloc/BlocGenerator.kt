package com.bloc.intellij_generator_plugin.generator.components.bloc

import com.bloc.intellij_generator_plugin.generator.bloc.BlocGenerator

class BlocGenerator(
    name: String
) : BlocGenerator(name, templateName = "bloc") {
    override fun fileName() = "${snakeCase()}_bloc.${fileExtension()}"
}