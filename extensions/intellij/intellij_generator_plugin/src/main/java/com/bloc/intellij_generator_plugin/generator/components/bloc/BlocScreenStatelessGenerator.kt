package com.bloc.intellij_generator_plugin.generator.components.bloc

import com.bloc.intellij_generator_plugin.generator.bloc.BlocGenerator

class BlocScreenStatelessGenerator(
    name: String
): BlocGenerator(name, templateName = "bloc_stateless_screen") {
    override fun fileName() = "${snakeCase()}_screen.${fileExtension()}"
}