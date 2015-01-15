package org.durcframework.expression.getter.impl;

import java.lang.annotation.Annotation;

import org.durcframework.expression.Expression;
import org.durcframework.expression.annotation.LikeDoubleField;
import org.durcframework.expression.getter.ExpressionGetter;
import org.durcframework.expression.subexpression.LikeDoubleExpression;
import org.springframework.util.StringUtils;

public class LikeDoubleExpressionGetter implements ExpressionGetter{

		@Override
		public Expression buildExpression(Annotation annotation, String column,
				Object value) {
			if (value == null) {
				return null;
			}
			if (value instanceof String) {
				if (!StringUtils.hasText((String) value)) {
					return null;
				}
			}
			LikeDoubleField valueField = (LikeDoubleField) annotation;
			String fieldColumn = valueField.column();
			if (StringUtils.hasText(fieldColumn)) {
				column = fieldColumn;
			}
			return new LikeDoubleExpression(valueField.joint(),column, value);
		}
		
	}