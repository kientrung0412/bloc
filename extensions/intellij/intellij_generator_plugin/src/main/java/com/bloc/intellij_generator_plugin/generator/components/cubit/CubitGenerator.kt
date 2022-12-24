package com.bloc.intellij_generator_plugin.generator.components.cubit

import com.bloc.intellij_generator_plugin.generator.cubit.CubitGenerator

class CubitGenerator(
    name: String
) : CubitGenerator(name, templateName = "cubit") {
    override fun fileName() = "${snakeCase()}_cubit.${fileExtension()}"
}