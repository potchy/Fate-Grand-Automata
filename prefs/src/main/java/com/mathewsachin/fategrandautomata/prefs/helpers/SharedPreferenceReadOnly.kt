package com.mathewsachin.fategrandautomata.prefs.helpers

import kotlin.properties.ReadOnlyProperty
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

internal fun <T, V> ReadWriteProperty<Any, T>.map(func: (T) -> V): ReadOnlyProperty<Any, V> =
    object : ReadOnlyProperty<Any, V> {
        override fun getValue(thisRef: Any, property: KProperty<*>): V =
            func(this@map.getValue(thisRef, property))
    }