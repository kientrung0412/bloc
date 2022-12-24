package com.bloc.intellij_generator_plugin.generator.components.bloc

import com.bloc.intellij_generator_plugin.generator.bloc.BlocGenerator

class BlocEventGenerator(
    blocName: String
) : BlocGenerator(blocName, templateName = "bloc_event") {

    override fun fileName() = "${snakeCase()}_event.${fileExtension()}"
}