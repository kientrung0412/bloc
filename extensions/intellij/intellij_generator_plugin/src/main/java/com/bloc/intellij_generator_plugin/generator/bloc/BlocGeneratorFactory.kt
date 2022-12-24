package com.bloc.intellij_generator_plugin.generator.bloc

import com.bloc.intellij_generator_plugin.generator.components.bloc.ExportGenerator
import com.bloc.intellij_generator_plugin.generator.components.bloc.*
import com.bloc.intellij_generator_plugin.generator.components.bloc.BlocGenerator

object BlocGeneratorFactory {
    fun getBlocGenerators(
        name: String,
        useStateful: Boolean
    ): List<com.bloc.intellij_generator_plugin.generator.bloc.BlocGenerator> {
        val bloc = BlocGenerator(name)
        val event = BlocEventGenerator(name)
        val state = BlocStateGenerator(name)
        val export = ExportGenerator(name)
        val screen =
            if (useStateful)
                BlocScreenStatefulGenerator(name)
            else
                BlocScreenStatelessGenerator(name)

        return listOf(bloc, event, state, screen, export)
    }
}