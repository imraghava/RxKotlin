package io.reactivex.rxkotlin

import io.reactivex.Single
import java.util.concurrent.Callable
import java.util.concurrent.Future

fun <T : Any> T.toSingle(): Single<T> = Single.just(this)
fun <T : Any> Future<T>.toSingle(): Single<T> = Single.fromFuture(this)
fun <T : Any> Callable<T>.toSingle(): Single<T> = Single.fromCallable(this)
fun <T : Any> (() -> T).toSingle(): Single<T> = Single.fromCallable(this)

inline fun <reified R : Any> Single<Any>.cast(): Single<R> = cast(R::class.java)
