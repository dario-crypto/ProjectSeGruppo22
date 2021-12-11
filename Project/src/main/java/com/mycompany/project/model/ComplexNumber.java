/**
 * <code>ComplexNumber</code> is a class which implements complex numbers in
 * Java. It includes basic operations that can be performed on complex numbers
 * such as, addition, subtraction, multiplication, conjugate, modulus and
 * squaring. The data type for Complex Numbers.
 * <br /><br />
 * The features of this library include:<br />
 * <ul>
 * <li>Arithmetic Operations (addition, subtraction, multiplication,
 * division)</li>
 * <li>Complex Specific Operations - Conjugate, Inverse, Absolute/Magnitude,
 * Argument/Phase</li>
 * <li>Trigonometric Operations - sin, cos, tan, cot, sec, cosec</li>
 * <li>Mathematical Functions - exp</li>
 * <li>Complex Parsing of type x+yi</li>
 * </ul>
 *
 * @author Abdul Fatir
 * @version	1.2
 *
 */
package com.mycompany.project.model;

import java.math.BigDecimal;
import java.util.ArrayList;

public class ComplexNumber {

    /**
     * Used in format(int) to format the complex number as x+yi
     */
    public static final int XY = 0;
    /**
     * Used in format(int) to format the complex number as
     * R.cis(theta), where theta is arg(z)
     */
    public static final int RCIS = 1;
    /**
     * The real, Re(z), part of the Complex Number.
     */
    private double real;
    /**
     * The imaginary, Im(z), part of the Complex Number.
     */
    private double imaginary;

    /**
     * Constructs a new Complex Number object with both real and
     * imaginary parts 0 (z = 0 + 0i).
     */
    public ComplexNumber() {
        real = 0.0;
        imaginary = 0.0;
    }

    /**
     * Constructs a new ComplexNumber object.
     *
     * @param real the real part, Re(z), of the complex number
     * @param imaginary the imaginary part, Im(z), of the complex number
     */
    public ComplexNumber(double real, double imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }

    /**
     * Adds another ComplexNumber to the current complex number.
     *
     * @param z the complex number to be added to the current complex number
     */
    public void add(ComplexNumber z) {
        set(add(this, z));
    }

    /**
     * Subtracts another ComplexNumber from the current complex
     * number.
     *
     * @param z the complex number to be subtracted from the current complex
     * number
     */
    public void subtract(ComplexNumber z) {
        set(subtract(this, z));
    }

    /**
     * Multiplies another ComplexNumber to the current complex
     * number.
     *
     * @param z the complex number to be multiplied to the current complex
     * number
     */
    public void multiply(ComplexNumber z) {
        set(multiply(this, z));
    }

    /**
     * Divides the current ComplexNumber by another
     * ComplexNumber.
     *
     * @param z the divisor
     */
    public void divide(ComplexNumber z) {
        set(divide(this, z));
    }

    /**
     * Sets the value of current complex number to the passed complex number.
     *
     * @param z the complex number
     */
    public void set(ComplexNumber z) {
        this.real = z.real;
        this.imaginary = z.imaginary;
    }
    
    /**
     * This method gives to the real part of a complex number the value given in input
     * @param real 
     */

    public void setReal(Double real) {
        this.real = real;
    }
    
    /**
     * This method gives to the imaginary part of a complex number the value given in
     * input
     *
     * @param real
     */

    public void setImaginary(Double imaginary) {
        this.imaginary = imaginary;
    }

    /**
     * Adds two ComplexNumber.
     *
     * @param z1 the first ComplexNumber.
     * @param z2 the second ComplexNumber.
     * @return the resultant ComplexNumber (z1 + z2).
     */
    public static ComplexNumber add(ComplexNumber z1, ComplexNumber z2) {
        return new ComplexNumber(z1.real + z2.real, z1.imaginary + z2.imaginary);
    }

    /**
     * Subtracts one ComplexNumber from another.
     *
     * @param z1 the first ComplexNumber.
     * @param z2 the second ComplexNumber.
     * @return the resultant ComplexNumber (z1 - z2).
     */
    public static ComplexNumber subtract(ComplexNumber z1, ComplexNumber z2) {
        return new ComplexNumber(z1.real - z2.real, z1.imaginary - z2.imaginary);
    }

    /**
     * Multiplies one ComplexNumber to another.
     *
     * @param z1 the first ComplexNumber.
     * @param z2 the second ComplexNumber.
     * @return the resultant ComplexNumber (z1 * z2).
     */
    public static ComplexNumber multiply(ComplexNumber z1, ComplexNumber z2) {
        double _real = z1.real * z2.real - z1.imaginary * z2.imaginary;
        double temp = z1.real * z2.imaginary;
        double temp2 = z1.imaginary * z2.real;
        double _imaginary = z1.real * z2.imaginary + z1.imaginary * z2.real;

        return new ComplexNumber(_real, _imaginary);
    }

    /**
     * Divides one ComplexNumber by another.
     *
     * @param z1 the first ComplexNumber.
     * @param z2 the second ComplexNumber.
     * @return the resultant ComplexNumber (z1 / z2).
     */
    public static ComplexNumber divide(ComplexNumber z1, ComplexNumber z2) {
        ComplexNumber output = multiply(z1, z2.conjugate());
        double div = multiply(z2, z2.conjugate()).real;
        if (div == 0) {
            throw new ArithmeticException("Division by zero");
        }
        return new ComplexNumber(output.real / div, output.imaginary / div);
    }

    /**
     * The complex conjugate of the current complex number.
     *
     * @return a ComplexNumber object which is the conjugate of the
     * current complex number
     */
    public ComplexNumber conjugate() {

        return new ComplexNumber(real, -imaginary);
    }

    /**
     * The modulus, magnitude or the absolute value of current complex number.
     *
     * @return the magnitude or modulus of current complex number
     */
    public double mod() {
        return (double) Math.round(Math.sqrt((Math.pow(this.real, 2) + Math.pow(this.imaginary, 2))) * 100000000) / 100000000;
    }

    /**
     * The square of the current complex number.
     *
     * @return a ComplexNumber which is the square of the current
     * complex number.
     */
    public ComplexNumber square() {
        double _real = this.real * this.real - this.imaginary * this.imaginary;
        double _imaginary = 2 * this.real * this.imaginary;
        return new ComplexNumber(_real, _imaginary);
    }

    /**
     * @return the complex number in x + yi format
     */
    @Override
    public String toString() {
        String re = this.real + "";
        String im = "";
        if (this.imaginary == -0.0) {
            this.imaginary = 0.0;
        }
        if (this.real == -0.0) {
            this.real = 0.0;
        }

        if (this.imaginary < 0) {
            im = this.imaginary + "i";
        } else {
            im = "+" + this.imaginary + "i";
        }

        if (this.imaginary == 0.0) {
            im = "";
        }
        return re + im;
    }

    /**
     * Calculates the exponential of the ComplexNumber
     *
     * @param z The input complex number
     * @return a ComplexNumber which is e^(input z)
     */
    public static ComplexNumber exp(ComplexNumber z) {
        double a = z.real;
        double b = z.imaginary;
        double r = Math.exp(a);
        a = (double) Math.round(r * Math.cos(b) * 100000000) / 100000000;
        b = (double) Math.round(r * Math.sin(b) * 100000000) / 100000000;
        return new ComplexNumber(a, b);
    }

    /**
     * Calculates the ComplexNumber to the passed power.
     *
     * @param z The input complex number
     * @param power The power.
     * @return a ComplexNumber which is (z)^power
     */
    public static ComplexNumber pow(ComplexNumber z, ComplexNumber power) {
        ComplexNumber output = new ComplexNumber(z.getRe(), z.getIm());
        if (power.getIm() == 0.0) {
            if(power.getRe()<0){
                Double pow=power.mod();
                ComplexNumber div=ComplexNumber.pow(z, new ComplexNumber(pow,0));
                output=ComplexNumber.divide(new ComplexNumber(1,0), div);
            }
            if (!checkDecimal(power.getRe())) {
                for (int i = 1; i < power.getRe(); i++) {
                    double _real = output.real * z.real - output.imaginary * z.imaginary;
                    double _imaginary = output.real * z.imaginary + output.imaginary * z.real;
                    output = new ComplexNumber(_real, _imaginary);
                }
            } else {
                String a = convertDecimalToFraction(power.getRe());
                String[] a1 = a.split("/");
                Double p = Double.parseDouble(a1[0]);
                Double r = Double.parseDouble(a1[1]);
                ComplexNumber b = ComplexNumber.pow(z, new ComplexNumber(p, 0.0));
                output = ComplexNumber.rootComplex(b, r);
            }
        } else if (z.getIm() == 0) {
            Double arg = power.getIm() * Math.log(z.getRe());
            Double re1 = (double) Math.round(Math.cos(arg) * 1000000000) / 1000000000;
            Double im1 = (double) Math.round(Math.sin(arg) * 1000000000) / 1000000000;
            Double value = Math.pow(z.getRe(), power.getRe());
            Double re = value * re1;
            Double im = value * im1;
            output = new ComplexNumber(re, im);

        } else {
            Double mod = z.mod();
            Double arg = z.getArg();
            ComplexNumber carg = new ComplexNumber(0.0, arg);

            ComplexNumber e = ComplexNumber.multiply(carg, power);

            ComplexNumber output1 = ComplexNumber.exp(new ComplexNumber(e.getRe(), 0));
            Double output2 = Math.pow(mod, power.getRe());
            Double r = output1.getRe() * output2 * Math.cos(e.getIm());
            Double i = output1.getRe() * output2 * Math.sin(e.getIm());
            ComplexNumber output3 = new ComplexNumber(r, i);
            ComplexNumber output4 = ComplexNumber.pow(new ComplexNumber(mod, 0), new ComplexNumber(0, power.getIm()));
            output = ComplexNumber.multiply(output3, output4);
            output.setReal((double) Math.round(output.getRe() * 1000000000) / 1000000000);
            output.setImaginary((double) Math.round(output.getIm() * 1000000000) / 1000000000);
        }

        return output;
    }

    /**
     * This method is used to convert a decimal number into a fraction
     *
     * @param x which is the decimal number that needs to be converted
     * @return String
     */
    static private String convertDecimalToFraction(double x) {
        if (x < 0) {
            return "-" + convertDecimalToFraction(-x);
        }
        double tolerance = 1.0E-6;
        double h1 = 1;
        double h2 = 0;
        double k1 = 0;
        double k2 = 1;
        double b = x;
        do {
            double a = Math.floor(b);
            double aux = h1;
            h1 = a * h1 + h2;
            h2 = aux;
            aux = k1;
            k1 = a * k1 + k2;
            k2 = aux;
            b = 1 / (b - a);
        } while (Math.abs(x - h1 / k1) > x * tolerance);

        return h1 + "/" + k1;
    }

    /**
     * This method checks if a number is decimal or not.
     *
     * @param n is the number that needs to be checked
     * @return true if is decimal, otherwise it returns false
     */
    private static boolean checkDecimal(Double n) {
        ArrayList<Double> a;
        String f = convertDecimalToFraction(n);
        String[] fr = f.split("/");
        if (fr[1].equals("1.0")) {
            return false;
        }
        return true;

    }
    
    /**
     * This method calculates the root of a real number
     * @param c is the rooting of the root
     * @param index is the index of the root
     * @return the root of c
     */

    public static ComplexNumber rootReal(ComplexNumber c, Double index) {
        Double newIndex = 1 / index;
        Double d = Math.pow(c.getRe(), newIndex);
        BigDecimal b1 = new BigDecimal(d).setScale(8, BigDecimal.ROUND_HALF_UP);
        Double root = Double.parseDouble(b1.toString());
        return new ComplexNumber(root, 0.0);
        

    }
    
    /**
     * This root calculates the root of a complex number
     * @param c is the rooting of the root
     * @param index is the index of the root
     * @return the root of c
     */

    public static ComplexNumber rootComplex(ComplexNumber c, Double index) {
        Double mod = c.mod();
        Double arg = c.getArg();
        ComplexNumber modC = rootReal(new ComplexNumber(mod, 0), index);
        ComplexNumber c1 = new ComplexNumber(0, 0);
        double period = 0.0;
        for (int i = 0; i < index; i++) {
            period += 2 * i * Math.PI;

        }

        Double re = modC.getRe() * (Math.cos((c.getArg() + period) / index));
        Double im = modC.getRe() * (Math.sin((c.getArg() + period) / index));
        c1.setReal(re);
        c1.setImaginary(im);
        return c1;

    }

    /**
     * Calculates the sine of the complex number
     *
     * @param z the input complex number
     * @return a ComplexNumber which is the sine of z.
     */
    public static ComplexNumber sin(ComplexNumber z) {
        double x = Math.exp(z.imaginary);
        double x_inv = 1 / x;
        double r = Math.sin(z.real) * (x + x_inv) / 2;
        double i = Math.cos(z.real) * (x - x_inv) / 2;
        return new ComplexNumber(r, i);
    }

    /**
     * Calculates the cosine of the complex number
     *
     * @param z the input complex number
     * @return a ComplexNumber which is the cosine of z.
     */
    public static ComplexNumber cos(ComplexNumber z) {
        double x = Math.exp(z.imaginary);
        double x_inv = 1 / x;
        double r = Math.cos(z.real) * (x + x_inv) / 2;
        double i = -Math.sin(z.real) * (x - x_inv) / 2;
        return new ComplexNumber(r, i);
    }

    /**
     * Calculates the tangent of the ComplexNumber
     *
     * @param z the input complex number
     * @return a ComplexNumber which is the tangent of z.
     */
    public static ComplexNumber tan(ComplexNumber z) {
        return divide(sin(z), cos(z));
    }

    /**
     * Calculates the co-tangent of the ComplexNumber
     *
     * @param z the input complex number
     * @return a ComplexNumber which is the co-tangent of z.
     */
    public static ComplexNumber cot(ComplexNumber z) {
        return divide(new ComplexNumber(1, 0), tan(z));
    }

    /**
     * Calculates the secant of the ComplexNumber
     *
     * @param z the input complex number
     * @return a ComplexNumber which is the secant of z.
     */
    public static ComplexNumber sec(ComplexNumber z) {
        return divide(new ComplexNumber(1, 0), cos(z));
    }

    /**
     * Calculates the co-secant of the ComplexNumber
     *
     * @param z the input complex number
     * @return a ComplexNumber which is the co-secant of z.
     */
    public static ComplexNumber cosec(ComplexNumber z) {
        return divide(new ComplexNumber(1, 0), sin(z));
    }

    /**
     * The real part of ComplexNumber
     *
     * @return the real part of the complex number
     */
    public double getRe() {
        return this.real;
    }

    /**
     * The imaginary part of ComplexNumber
     *
     * @return the imaginary part of the complex number
     */
    public double getIm() {
        return this.imaginary;
    }

    /**
     * The argument/phase of the current complex number.
     *
     * @return arg(z) - the argument of current complex number
     */
    public double getArg() {
        return (double) Math.round(Math.atan2(imaginary, real) * 1000000000) / 1000000000;
    }

    /**
     * Parses the String as a ComplexNumber of type
     * x+yi.
     *
     * @param s the input complex number as string
     * @return a ComplexNumber which is represented by the string.
     */
    public static ComplexNumber parseComplex(String s) {
        long count = s.chars().filter(ch -> ch == 'i').count();
        if (count > 1) {
            return null;

        }

        if (s.charAt(0) == '+') {
            s = s.substring(1);
        }

        s = s.replaceAll(" ", "");
        ComplexNumber parsed = null;
        if (s.contains(String.valueOf("+")) || (s.contains(String.valueOf("-")) && s.lastIndexOf('-') > 0)) {
            String re = "";
            String im = "";

            //bi+a
            if (!s.endsWith("i")) {
                im = s.substring(0, s.indexOf('i'));
                re = s.substring(s.indexOf('i') + 1, s.length());
                parsed = new ComplexNumber(Double.parseDouble(re), Double.parseDouble(im));
            } else {
                s = s.replaceAll("i", "");
                //a[+-]bi
                if (s.indexOf('+') > 0) {
                    re = s.substring(0, s.indexOf('+'));
                    im = s.substring(s.indexOf('+') + 1, s.length());
                    parsed = new ComplexNumber(Double.parseDouble(re), Double.parseDouble(im));
                    //a-bi
                } else if (s.lastIndexOf('-') > 0) {
                    re = s.substring(0, s.lastIndexOf('-'));
                    im = s.substring(s.lastIndexOf('-') + 1, s.length());
                    parsed = new ComplexNumber(Double.parseDouble(re), -Double.parseDouble(im));
                }
            }
        } else {
            // Pure imaginary number
            if (s.endsWith("i")) {
                s = s.replaceAll("i", "");
                parsed = new ComplexNumber(0, Double.parseDouble(s));
            } // Pure real number
            else {
                parsed = new ComplexNumber(Double.parseDouble(s), 0);
            }
        }
        return parsed;
    }

    /**
     * Checks if the passed ComplexNumber is equal to the current.
     *
     * @param z the complex number to be checked
     * @return true if they are equal, false otherwise
     */
    @Override
    public final boolean equals(Object z) {
        if (!(z instanceof ComplexNumber)) {
            return false;
        }
        ComplexNumber a = (ComplexNumber) z;
        return (real == a.real) && (imaginary == a.imaginary);
    }

    /**
     * The inverse/reciprocal of the complex number.
     *
     * @return the reciprocal of current complex number.
     */
    public ComplexNumber inverse() {
        return divide(new ComplexNumber(1, 0), this);
    }

    /**
     * Formats the Complex number as x+yi or r.cis(theta)
     *
     * @param format_id the format ID ComplexNumber.XY or
     * ComplexNumber.RCIS.
     * @return a string representation of the complex number
     * @throws IllegalArgumentException if the format_id does not match.
     */
    public String format(int format_id) throws IllegalArgumentException {
        String out = "";
        if (format_id == XY) {
            out = toString();
        } else if (format_id == RCIS) {
            out = mod() + " cis(" + getArg() + ")";
        } else {
            throw new IllegalArgumentException("Unknown Complex Number format.");
        }
        return out;
    }
    
    /**
     * This metod calculates the square root of the complex number
     * @return the result of the square root
     */

    public ComplexNumber sqrt() {
        double r = this.mod();
        double halfTheta = this.getArg() / 2;
        double real = (double) Math.round(Math.sqrt(r) * Math.round(Math.cos(halfTheta) * 100000000)) / 100000000;
        double image = (double) Math.round(Math.sqrt(r) * Math.sin(halfTheta) * 100000000) / 100000000;
        return new ComplexNumber(real, image);
    }

    /**
     * This method Inverts the sign of a complex number
     */
    public void invertSign() {
        real = -real;
        imaginary = -imaginary;
    }
    
    /**
     * This method clones a Complex Number
     * @return a Complex Number 
     */

    @Override
    public Object clone() {
        return new ComplexNumber(real, imaginary);
    }
    
    /**
     * This method calculates the sine of a Complex Number
     * @param z is the input of the sine
     * @return the sine of z
     */

    public ComplexNumber sen(ComplexNumber z) {
        double x = Math.exp(z.imaginary);
        double x_inv = 1 / x;
        double r = (double) Math.round((Math.sin(z.real) * (x + x_inv) / 2) * 100000000) / 100000000;
        double i = (double) Math.round((Math.cos(z.real) * (x - x_inv) / 2) * 100000000) / 100000000;
        return new ComplexNumber(r, i);
    }
    
    /**
     * This method calculates the cosine of a Complex Number
     * @param z is the input of the cosine
     * @return the cosine of z
     */

    public ComplexNumber cosen(ComplexNumber z) {
        double x = Math.exp(z.imaginary);
        double x_inv = 1 / x;
        double r = (double) Math.round((Math.cos(z.real) * (x + x_inv) / 2) * 100000000) / 100000000;
        double i = (double) Math.round(-(Math.sin(z.real) * (x - x_inv) / 2) * 100000000) / 100000000;
        return new ComplexNumber(r, i);
    }
    
    /**
     * This method calculates the tangent of a complex number
     * @param z is the input of the tangent
     * @return the tangent of z
     */

    public ComplexNumber tang(ComplexNumber z) {
        return divide(sen(z), cosen(z));
    }
    
    /**
     * This method checks if the string input is a complex number
     * @param s the string that needs to be checked
     * @return true if s is a complex number, otherwise false
     */

    public static boolean checkComplex(String s) {
        try {
            ComplexNumber c = ComplexNumber.parseComplex(s);
            if (c == null) {
                return false;
            }
        } catch (Exception e) {
            return false;
        }

        return true;

    }
    
    /**
     * This method calculates the logarithm of a complex number
     * @return the logarithm of a complex number
     */
     public ComplexNumber logarithm() {
        double z=mod();
        double real = (double) Math.round( Math.log(z)*100000000)/100000000;
        double image =(double) Math.round(getArg()*100000000)/100000000;
        return new ComplexNumber(real, image);
    }
     
     /**
      * This method calculates the arsine of a ComplexNumber
      * @param z the input of the arsine
      * @return the arsine of z
      */

public double asen(ComplexNumber z){
        double r = z.real;
        double i = z.imaginary;
        if (z.real > 1 || z.real < -1 ) {
            throw new ArithmeticException("Number not included in [-1,1]");
        }
        return Math.asin(r+i);
    }
    
    /**
     * This method calculates the arc cosine of a complex number
     * @param z the input of the arcosine
     * @return the arcosine of z
     */

public double acosen(ComplexNumber z){
        double r = z.real;
        double i = z.imaginary;
        if (z.real > 1 || z.real < -1 ) {
            throw new ArithmeticException("Number not included in [-1,1]");
        }
        return Math.acos(r+i);
    }
    
    /**
     * This method calculates the arc tangent of a complex number
     * @param z the input of the arc tangent
     * @return the arc tangent of z
     */

    public double atang(ComplexNumber z) {
        double r = z.real;
        double i = z.imaginary;
        return Math.atan(r + i);
    }

}
