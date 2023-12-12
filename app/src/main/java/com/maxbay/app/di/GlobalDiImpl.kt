package com.maxbay.app.di

import com.gefest.di.GlobalDi
import kotlin.reflect.KClass

@Suppress("UNCHECKED_CAST")
class GlobalDiImpl: GlobalDi {
    private val classes = mutableMapOf<Any, Any>()

    override fun <T : Any> get(class_: KClass<T>): T {
        return if (classes.containsKey(class_)) {
            classes[class_] as T
        }else {
            throw IllegalStateException("$class_ not found in di container")
        }
    }

    override fun <T : Any> add(key: KClass<T>, object_: T) {
        classes[key] = object_
    }
}