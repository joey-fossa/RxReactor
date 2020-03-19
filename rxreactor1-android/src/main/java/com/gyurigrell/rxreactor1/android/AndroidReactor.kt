package com.gyurigrell.rxreactor1.android

import com.gyurigrell.rxreactor1.Reactor
import rx.Observable
import rx.android.schedulers.AndroidSchedulers

/**
 * Specialized implementation of [Reactor] that ensures [state] Observables emits on [AndroidSchedulers.mainThread]
 */
class AndroidReactor<Action, Mutation, State>(initialState: State): Reactor<Action, Mutation, State>(initialState) {
    override fun transformState(state: Observable<State>): Observable<State> = state.observeOn(AndroidSchedulers.mainThread())
}