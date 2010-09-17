/*
 * Copyright (c) 2010 Mysema Ltd.
 * All rights reserved.
 *
 */
package com.mysema.query.types.expr;

import javax.annotation.Nullable;

import com.mysema.query.types.ConstantImpl;
import com.mysema.query.types.Expression;
import com.mysema.query.types.Operator;
import com.mysema.query.types.Ops;
import com.mysema.query.types.Path;
import com.mysema.query.types.PathImpl;

/**
 * StringExpression represents String expressions
 *
 * @author tiwe
 * @see java.lang.String
 */
public abstract class StringExpression extends ComparableExpression<String> {

    private static final long serialVersionUID = 1536955079961023361L;

    @Nullable
    private volatile NumberExpression<Integer> length;

    @Nullable
    private volatile StringExpression lower, trim, upper;

    @Nullable
    private volatile BooleanExpression isempty;

    public StringExpression() {
        super(String.class);
    }

    @SuppressWarnings("unchecked")
    @Override
    public StringExpression as(Path<String> alias) {
        return StringOperation.create((Operator)Ops.ALIAS, this, alias);
    }
    
    @SuppressWarnings("unchecked")
    @Override
    public StringExpression as(String alias) {
        return StringOperation.create((Operator)Ops.ALIAS, this, new PathImpl<String>(getType(), alias));
    }

    /**
     * Get the concatenation of this and str
     *
     * @param str
     * @return this + str
     */
    public StringExpression append(Expression<String> str) {
        return StringOperation.create(Ops.CONCAT, this, str);
    }

    /**
     * Get the concatenation of this and str
     *
     * @param str
     * @return this + str
     */
    public StringExpression append(String str) {
        return append(ConstantImpl.create(str));
    }

    /**
     * Get the character at the given index
     *
     * @param i
     * @return this.charAt(i)
     * @see java.lang.String#charAt(int)
     */
    public SimpleExpression<Character> charAt(Expression<Integer> i) {
        return ComparableOperation.create(Character.class, Ops.CHAR_AT, this, i);
    }

    /**
     * Get the character at the given index
     *
     * @param i
     * @return this.charAt(i)
     * @see java.lang.String#charAt(int)
     */
    public SimpleExpression<Character> charAt(int i) {
        return charAt(ConstantImpl.create(i));
    }

    /**
     * Get the concatenation of this and str
     *
     * @param str
     * @return this + str
     */
    public StringExpression concat(Expression<String> str) {
        return append(str);
    }

    /**
     * Get the concatenation of this and str
     *
     * @param str
     * @return this + str
     */
    public StringExpression concat(String str) {
        return append(str);
    }

    /**
     * Returns true if the given String is contained
     *
     * @param str
     * @return this.contains(str)
     * @see java.lang.String#contains(CharSequence)
     */
    public BooleanExpression contains(Expression<String> str) {
        return BooleanOperation.create(Ops.STRING_CONTAINS, this, str);
    }

    /**
     * Returns true if the given String is contained
     *
     * @param str
     * @return this.contains(str)
     * @see java.lang.String#contains(CharSequence)
     */
    public BooleanExpression contains(String str) {
        return contains(ConstantImpl.create(str));
    }
    
    /**
     * @param str
     * @return
     */
    public BooleanExpression containsIgnoreCase(Expression<String> str) {
        return BooleanOperation.create(Ops.STRING_CONTAINS_IC, this, str);
    }
   
    /**
     * @param str
     * @return
     */
    public BooleanExpression containsIgnoreCase(String str) {
        return containsIgnoreCase(ConstantImpl.create(str));
    }
    
    /**
     * Returns true if this ends with str
     *
     * @param str
     * @return this.endsWith(str)
     * @see java.lang.String#endsWith(String)
     */
    public BooleanExpression endsWith(Expression<String> str) {
        return BooleanOperation.create(Ops.ENDS_WITH, this, str);
    }
    
    /**
     * @param str
     * @return
     */
    public BooleanExpression endsWithIgnoreCase(Expression<String> str){
        return BooleanOperation.create(Ops.ENDS_WITH_IC, this, str);
    }

    /**
     * Returns true if this ends with str
     *
     * @param str
     * @return this.endsWith(str)
     * @see java.lang.String#endsWith(String)
     */
    public BooleanExpression endsWith(String str) {
        return endsWith(ConstantImpl.create(str));
    }
    
    /**
     * @param str
     * @return
     */
    public BooleanExpression endsWithIgnoreCase(String str) {
        return endsWithIgnoreCase(ConstantImpl.create(str));
    }

    /**
     * Compares this {@code EString} to another {@code EString}, ignoring case
     * considerations.
     *
     * @param str
     * @return this.equalsIgnoreCase(str)
     * @see java.lang.String#equalsIgnoreCase(String)
     */
    public BooleanExpression equalsIgnoreCase(Expression<String> str) {
        return BooleanOperation.create(Ops.EQ_IGNORE_CASE, this, str);
    }

    /**
     * Compares this {@code EString} to another {@code EString}, ignoring case
     * considerations.
     *
     * @param str
     * @return this.equalsIgnoreCase(str)
     * @see java.lang.String#equalsIgnoreCase(String)
     */
    public BooleanExpression equalsIgnoreCase(String str) {
        return equalsIgnoreCase(ConstantImpl.create(str));
    }

    /**
     * Get the index of the given substring in this String
     *
     * @param str
     * @return this.indexOf(str)
     * @see java.lang.String#indexOf(String)
     */
    public NumberExpression<Integer> indexOf(Expression<String> str) {
        return NumberOperation.create(Integer.class, Ops.INDEX_OF, this, str);
    }

    /**
     * Get the index of the given substring in this String
     *
     * @param str
     * @return this.indexOf(str)
     * @see java.lang.String#indexOf(String)
     */
    public NumberExpression<Integer> indexOf(String str) {
        return indexOf(ConstantImpl.create(str));
    }

    /**
     * Get the index of the given substring in this String, starting from the given index
     *
     * @param str
     * @param i
     * @return this.indexOf(str, i)
     * @see java.lang.String#indexOf(String, int)
     */
    public NumberExpression<Integer> indexOf(String str, int i) {
        return indexOf(ConstantImpl.create(str), i);
    }

    /**
     * Get the index of the given substring in this String, starting from the given index
     *
     * @param str
     * @param i
     * @return
     */
    public NumberExpression<Integer> indexOf(Expression<String> str, int i) {
        return NumberOperation.create(Integer.class, Ops.INDEX_OF_2ARGS, this, str, ConstantImpl.create(i));
    }

    /**
     * Return true if this String is empty
     *
     * @return this.isEmpty()
     * @see java.lang.String#isEmpty()
     */
    public BooleanExpression isEmpty(){
        if (isempty == null){
            isempty = BooleanOperation.create(Ops.STRING_IS_EMPTY, this);
        }
        return isempty;
    }

    /**
     * Return true if this String is not empty
     *
     * @return !this.isEmpty()
     * @see java.lang.String#isEmpty()
     */
    public BooleanExpression isNotEmpty(){
        return isEmpty().not();
    }

    /**
     * Return the length of this String
     *
     * @return this.length()
     * @see java.lang.String#length()
     */
    public NumberExpression<Integer> length() {
        if (length == null) {
            length = NumberOperation.create(Integer.class, Ops.STRING_LENGTH, this);
        }
        return length;
    }

    /**
     * Expr: <code>this like str</code>
     *
     * @param str
     * @return
     */
    public BooleanExpression like(String str){
        return BooleanOperation.create(Ops.LIKE, this, ConstantImpl.create(str));
    }

    /**
     * Expr: <code>this like str</code>
     *
     * @param str
     * @return
     */
    public BooleanExpression like(StringExpression str){
        return BooleanOperation.create(Ops.LIKE, this, str);
    }

    /**
     * Get the lower case form
     *
     * @return this.toLowerCase()
     * @see java.lang.String#toLowerCase()
     */
    public StringExpression lower() {
        if (lower == null) {
            lower = StringOperation.create(Ops.LOWER, this);
        }
        return lower;
    }

    /**
     * Return true if this String matches the given regular expression
     *
     * @param regex
     * @return this.matches(right)
     * @see java.lang.String#matches(String)
     */
    public BooleanExpression matches(Expression<String> regex){
        return BooleanOperation.create(Ops.MATCHES, this, regex);
    }

    /**
     * Return true if this String matches the given regular expression
     *
     * @param regex
     * @return this.matches(regex)
     * @see java.lang.String#matches(String)
     */
    public BooleanExpression matches(String regex){
        return matches(ConstantImpl.create(regex));
    }

    /**
     * Prepend the given String and return the result
     *
     * @param str
     * @return str + this
     */
    public StringExpression prepend(Expression<String> str) {
        return StringOperation.create(Ops.CONCAT, str, this);
    }

    /**
     * Prepend the given String and return the result
     *
     * @param str
     * @return str + this
     */
    public StringExpression prepend(String str) {
        return prepend(ConstantImpl.create(str));
    }

    /**
     * Split the given String with regex as the matcher for the separator
     *
     * @param regex
     * @return this.split(regex)
     * @see java.lang.String#split(String)
     */
    public Expression<String[]> split(String regex) {
        return SimpleOperation.create(String[].class, Ops.StringOps.SPLIT, this, ConstantImpl.create(regex));
    }

    /**
     * Return true if this starts with str
     *
     * @param str
     * @return this.startsWith(str)
     * @see java.lang.String#startsWith(String)
     */
    public BooleanExpression startsWith(Expression<String> str) {
        return BooleanOperation.create(Ops.STARTS_WITH, this, str);
    }
    
    /**
     * @param str
     * @return
     */
    public BooleanExpression startsWithIgnoreCase(Expression<String> str) {
        return BooleanOperation.create(Ops.STARTS_WITH_IC, this, str);
    }

    /**
     * Return true if this starts with str
     *
     * @param str
     * @return this.startsWith(str)
     * @see java.lang.String#startsWith(String)
     */
    public BooleanExpression startsWith(String str) {
        return startsWith(ConstantImpl.create(str));
    }
    
    /**
     * @param str
     * @return
     */
    public BooleanExpression startsWithIgnoreCase(String str) {
        return startsWithIgnoreCase(ConstantImpl.create(str));
    }

    /* (non-Javadoc)
     * @see com.mysema.query.types.expr.EComparable#stringValue()
     */
    public StringExpression stringValue() {
        return this;
    }

    /**
     * Get the given substring
     *
     * @param beginIndex
     * @return this.substring(beginIndex)
     * @see java.lang.String#substring(int)
     */
    public StringExpression substring(int beginIndex) {
        return StringOperation.create(Ops.SUBSTR_1ARG, this, ConstantImpl.create(beginIndex));
    }

    /**
     * Get the given substring
     *
     * @param beginIndex
     * @param endIndex
     * @return this.substring(beginIndex, endIndex)
     * @see java.lang.String#substring(int, int)
     */
    public StringExpression substring(int beginIndex, int endIndex) {
        return StringOperation.create(Ops.SUBSTR_2ARGS, this, ConstantImpl.create(beginIndex), ConstantImpl.create(endIndex));
    }

    /**
     * Get the lower case form
     *
     * @return this.toLowerCase()
     * @see java.lang.String#toLowerCase()
     */
    public StringExpression toLowerCase() {
        return lower();
    }

    /**
     * Get the upper case form
     *
     * @return
     * @see java.lang.String#toUpperCase()
     */
    public StringExpression toUpperCase() {
        return upper();
    }

    /**
     * Get a copy of the string, with leading and trailing whitespace
     * omitted.
     *
     * @return
     * @see java.lang.String#trim()
     */
    public StringExpression trim() {
        if (trim == null) {
            trim = StringOperation.create(Ops.TRIM, this);
        }
        return trim;
    }

    /**
     * Get the upper case form
     *
     * @return
     * @see java.lang.String#toUpperCase()
     */
    public StringExpression upper() {
        if (upper == null) {
            upper = StringOperation.create(Ops.UPPER, this);
        }
        return upper;
    }

}
