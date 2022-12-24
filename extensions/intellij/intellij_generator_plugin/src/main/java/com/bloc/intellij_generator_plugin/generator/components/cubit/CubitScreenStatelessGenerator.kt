package com.bloc.intellij_generator_plugin.generator.components.cubit

import com.bloc.intellij_generator_plugin.generator.cubit.CubitGenerator

class CubitScreenStatelessGenerator(
    name: String
) : CubitGenerator(name, templateName = "cubit_stateless_screen") {
    override fun fileName() = "${snakeCase()}_screen.${fileExtension()}"
}