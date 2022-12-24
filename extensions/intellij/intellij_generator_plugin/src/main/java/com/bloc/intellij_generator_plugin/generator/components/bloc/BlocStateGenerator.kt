package com.bloc.intellij_generator_plugin.generator.components.bloc

import com.bloc.intellij_generator_plugin.generator.bloc.BlocGenerator

class BlocStateGenerator(
    name: String
) : BlocGenerator(name, templateName = "bloc_state") {
    override fun fileName() = "${snakeCase()}_state.${fileExtension()}"
}