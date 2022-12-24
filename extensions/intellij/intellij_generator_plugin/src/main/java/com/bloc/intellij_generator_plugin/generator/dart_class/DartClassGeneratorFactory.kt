package com.bloc.intellij_generator_plugin.generator.dart_class

import com.bloc.intellij_generator_plugin.generator.components.cubit.CubitGenerator
import com.bloc.intellij_generator_plugin.generator.components.cubit.CubitScreenStatefulGenerator
import com.bloc.intellij_generator_plugin.generator.components.cubit.CubitScreenStatelessGenerator
import com.bloc.intellij_generator_plugin.generator.components.cubit.CubitStateGenerator

object DartClassGeneratorFactory {
    fun getCubitGenerators(
        name: String,
        useStateful: Boolean
    ): List<DartClassGenerator> {
//        val cubit = CubitGenerator(name)
//        val state = CubitStateGenerator(name)
//        val screen =
//            if (useStateful)
//                CubitScreenStatefulGenerator(name)
//            else
//                CubitScreenStatelessGenerator(name)

        return listOf()
    }
}