package com.whaletail.testtask

import io.reactivex.Completable
import io.reactivex.Maybe
import io.reactivex.Observable
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers


fun <T> Single<T>.printError(): Single<T> = doOnError { it.printStackTrace() }
fun <T> Single<T>.printError(action: (t : Throwable) -> (Unit)): Single<T> = doOnError {
    action(it)
    it.printStackTrace()
}

fun <T> Maybe<T>.printError(): Maybe<T> = doOnError { it.printStackTrace() }
fun <T> Maybe<T>.printError(action: (t : Throwable) -> (Unit)): Maybe<T> = doOnError {
    action(it)
    it.printStackTrace()
}

fun Completable.printError(): Completable = doOnError { it.printStackTrace() }
fun <T> Completable.printError(action: (t : Throwable) -> (Unit)): Completable = doOnError {
    action(it)
    it.printStackTrace()
}

fun <T> Observable<T>.printError(): Observable<T> = doOnError { it.printStackTrace() }
fun <T> Observable<T>.printError(action: (t : Throwable) -> (Unit)): Observable<T> = doOnError {
    action(it)
    it.printStackTrace()
}

fun runOnIo(action: () -> (Unit)): Completable = Completable.fromAction { action() }.subscribeOn(Schedulers.io())
fun Completable.runOnIo(): Completable = subscribeOn(Schedulers.io())
fun <T> Single<T>.runOnIo(): Single<T> = subscribeOn(Schedulers.io())
fun <T> Maybe<T>.runOnIo(): Maybe<T> = subscribeOn(Schedulers.io())