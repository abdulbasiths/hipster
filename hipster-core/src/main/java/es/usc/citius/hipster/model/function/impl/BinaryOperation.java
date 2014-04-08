/*
 * Copyright 2014 CITIUS <http://citius.usc.es>, University of Santiago de Compostela.
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */
package es.usc.citius.hipster.model.function.impl;

import es.usc.citius.hipster.model.function.BinaryFunction;

/**
 * A binary operation is an implementation of {@link es.usc.citius.lab.hipster.function.BinaryFunction} that also
 * has the following definitions:
 * <ul>
 * 		<li>identity element (A*I = A)</li>
 * 		<li>maximum element (A*M = M)</li>
 * </ul>
 * 
 * @author Pablo Rodríguez Mier <pablo.rodriguez.mier@usc.es>
 *
 * @param <E> operator class
 */
public class BinaryOperation<E extends Comparable<E>> implements BinaryFunction<E> {

	private E maxElem;
	private E identityElem;
	private BinaryFunction<E> op;

	public BinaryOperation(BinaryFunction<E> operation, E identityElem, E maxElem) {
		this.maxElem = maxElem;
		this.identityElem = identityElem;
		this.op = operation;
	}

	public E apply(E a, E b) {
		return this.op.apply(a, b);
	}
	
	public E getMaxElem() {
		return maxElem;
	}

	public E getIdentityElem() {
		return identityElem;
	}

    /**
     * Returns a default addition implementation which works with doubles.
     * For example, {@literal BinaryOperation.doubleAdditionOp().apply(2.5d, 1.0d)} returns 3.5d.
     * @return
     */
	public static BinaryOperation<Double> doubleAdditionOp() {
		return new BinaryOperation<Double>(new BinaryFunction<Double>() {
			public Double apply(Double a, Double b) {
				return a + b;
			}
		}, 0d, Double.POSITIVE_INFINITY);
	}

    /**
     * Returns a multiplication implementation which works with doubles.
     * For example, {@literal BinaryOperation.doubleMultiplicationOp.apply(2.5d, 2.0d)} returns 5.0d.
     * @return
     */
	public static BinaryOperation<Double> doubleMultiplicationOp() {
		return new BinaryOperation<Double>(new BinaryFunction<Double>() {

			public Double apply(Double a, Double b) {
				return a * b;
			}
		}, 1d, Double.POSITIVE_INFINITY);
	}
}