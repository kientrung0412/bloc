package com.bloc.intellij_generator_plugin.generator.components.bloc

import com.bloc.intellij_generator_plugin.generator.bloc.BlocGenerator

class BlocScreenStatefulGenerator(
    name: String
) : BlocGenerator(name, templateName = "bloc_stateful_screen") {
    override fun fileName() = "${snakeCase()}_screen.${fileExtension()}"
}