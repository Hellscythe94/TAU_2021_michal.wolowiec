package pl.pjwstk.s13119.tau.app;

import static java.lang.Double.NaN;
import pl.pjwstk.s13119.tau.exceptions.*;

import static java.lang.Math.log10;
import static java.lang.Math.pow;

public class Calculator {

    public enum BiOperatorModes {
        normal, add, minus, multiply, divide , xpowerofy 
    }

    public enum MonoOperatorModes {
        square, squareRoot, oneDividedBy, cos, sin, tan ,log , rate, abs, notImplementedMode
    }
    
    public Double simpleAdd(Double num1, Double num2) {
    	return num1+num2;
    }
    
    public Double simpleSubtract(Double num1, Double num2) {
    	return num1-num2;
    }
    
    public Double simpleMultiply(Double num1, Double num2) {
    	return num1*num2;
    }
    
    public Double simpleDivide(Double num1, Double num2) {
    	return num1/num2;
    }
    
    public Double simpleModulo(Double num1, Double num2) {
    	return num1%num2;
    }

    public Double calculateBiImpl(BiOperatorModes mode, Double num1, Double num2) throws WrongModeException {
        if (mode == BiOperatorModes.add) {
            if (num2 != 0) {
                return num1 + num2;
            }

            return num1;
        }
        if (mode == BiOperatorModes.minus) {
            return num1 - num2;
        }
        if (mode == BiOperatorModes.multiply) {
            return num1 * num2;
        }
        if (mode == BiOperatorModes.divide) {
            return num1 / num2;
        }
        if (mode == BiOperatorModes.xpowerofy) {
            return pow(num1,num2);
        }

        // never reach
        throw new WrongModeException("Wrong Bi Mode", new Throwable());
    }

    public Double calculateMono(MonoOperatorModes newMode, Double num) throws WrongModeException {
        if (newMode == MonoOperatorModes.square) {
            return num * num;
        }
        if (newMode == MonoOperatorModes.squareRoot) {
            return Math.sqrt(num);
        }
        if (newMode == MonoOperatorModes.oneDividedBy) {
            return 1 / num;
        }
        if (newMode == MonoOperatorModes.cos) {
            return Math.cos(Math.toRadians(num));
        }
        if (newMode == MonoOperatorModes.sin) {
            return Math.sin(Math.toRadians(num));
        }
        if (newMode == MonoOperatorModes.tan) {
            if (num == 0 || num % 180 == 0) {
                return 0.0;
            }
            if (num % 90 == 0 && num % 180 != 0) {
                return NaN;
            }

            return Math.tan(Math.toRadians(num));
        }
        if (newMode == MonoOperatorModes.log) {
            return log10(num);
        }
        if (newMode == MonoOperatorModes.rate) {
           return num / 100;
        }
        if (newMode == MonoOperatorModes.abs){
            return Math.abs(num);
        }

        // never reach
        throw new WrongModeException("Wrong Mono Mode", new Throwable());
    }

}