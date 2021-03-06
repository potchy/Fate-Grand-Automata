package com.mathewsachin.libautomata

import javax.inject.Inject
import javax.inject.Singleton

/**
 * Manages the termination of running scripts
 */
@Singleton
class ExitManager @Inject constructor() {
    @Volatile
    private var exitRequested = false

    /**
     * Checks if the stop button has been pressed.
     *
     * @throws ScriptAbortException if the button has been pressed
     */
    fun checkExitRequested() {
        if (exitRequested) {
            throw ScriptAbortException()
        }
    }

    /**
     * Requests exit
     */
    fun request() {
        exitRequested = true
    }

    /**
     * Cancels exit request
     */
    fun cancel() {
        exitRequested = false
    }
}