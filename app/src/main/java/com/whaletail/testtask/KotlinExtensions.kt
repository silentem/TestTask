package com.whaletail.testtask

import android.annotation.TargetApi
import android.content.Context
import android.graphics.Rect
import android.os.Build
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProviders
import java.lang.reflect.ParameterizedType
import java.util.*

@Suppress("UNCHECKED_CAST")
inline fun <reified T, reified I> T.getAsInterface(): I? {
    return if (I::class.java.isInterface) return this as I else null
}

@Suppress("UNCHECKED_CAST")
fun <T> Any.getClassOfGeneric(): Class<T>? {
    return (javaClass.genericSuperclass as? ParameterizedType)?.actualTypeArguments?.get(0) as? Class<T>
}

@Suppress("UNCHECKED_CAST")
fun <T> Any.getClassOfGenericNonNull(): Class<T> {
    return (javaClass.genericSuperclass as ParameterizedType).actualTypeArguments[0] as Class<T>
}

@Suppress("UNCHECKED_CAST")
inline fun <reified T> String.getClass(): Class<T>? {
    val clazz = Class.forName(this)
    return if (T::class.java.isAssignableFrom(clazz)) clazz as Class<T> else null
}

fun <T> T.applyOnly(block: T.() -> Unit) {
    this?.block()
}

fun <T, R> T.applyWith(`object`: R?, block: T.(R) -> Unit) {
    `object`?.let { obj -> this?.block(obj) }
}

fun <T, R> T.applyWithReturn(`object`: R?, block: T.(R) -> Unit): T {
    `object`?.let { obj -> this?.block(obj) }
    return this
}

fun <T, R> T.applyWithReturnLetWith(`object`: R?, block: T.(R) -> Unit, fail: () -> Unit): T? {
    `object`?.let { obj -> this?.block(obj) } ?: fail()
    return this
}

fun View.location(): Rect {
    return Rect().apply { this@location.getGlobalVisibleRect(this) }
}

fun <T1, T2> notNull(t1: T1?, t2: T2?, block: (T1, T2) -> Unit) {
    if (t1 != null && t2 != null) block(t1, t2)
}

fun <T1, T2, T3> notNull(t1: T1?, t2: T2?, t3: T3?, block: (T1, T2, T3) -> Unit) {
    if (t1 != null && t2 != null && t3 != null) block(t1, t2, t3)
}

fun <T> T.applyIf(condition: Boolean, appliance: T.() -> Unit): T {
    if (condition) this.appliance()
    return this
}

fun <T, R> T.transform(transform: (T) -> R): R {
    return transform(this)
}

fun <T> Iterable<T>.forEachToCollection(forEachAction: T.(Iterable<T>) -> Unit) {
    this.forEach { it.forEachAction(this) }
}

fun <T1, T2> T1.notNull(nullable: T2?): T1? {
    return if (nullable != null) this else null
}

fun localeByLanguage(languageCode: String?): Locale {
    return Locale.getAvailableLocales().firstOrNull { it.language == languageCode } ?: Locale.getDefault()
}

fun <T> T.oneOf(vararg args: T): Boolean {
    return args.any { it == this }
}

fun <T> T?.isNull() = this == null
fun <T> T?.isNotNull() = this != null

fun <T, R> Iterable<T>.forEachCollect(action: (T) -> List<R>): List<R> {
    val result = mutableListOf<R>()
    this.forEach { result.addAll(action(it)) }
    return result
}

fun <T1, T2> T1?.letWith(arg: T2?, action: (T1, T2) -> Unit) {
    notNull(this, arg, action)
}

fun <T1, T2> T1?.letWithReturn(arg: T2?, action: (T1, T2) -> Unit): T1? {
    if (this != null && arg != null) action(this, arg)
    return this
}

fun Float?.intString(): String {
    return this.toString().split(".")[0]
}
