package pl.stepwise

import io.micronaut.runtime.Micronaut.*
fun main(args: Array<String>) {
	build()
	    .args(*args)
		.packages("pl.stepwise")
		.start()
}

