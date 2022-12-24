package com.bloc.intellij_generator_plugin.generator.components.cubit

import com.bloc.intellij_generator_plugin.generator.cubit.CubitGenerator

class CubitStateGenerator(
    name: String
) : CubitGenerator(name, templateName = "cubit_state") {
    override fun fileName() = "${snakeCase()}_state.${fileExtension()}"
}