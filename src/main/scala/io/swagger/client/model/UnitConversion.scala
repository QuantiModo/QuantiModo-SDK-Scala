package io.swagger.client.model

import org.joda.time.DateTime



case class UnitConversion (
  /* unit_id */
  unit_id: Integer,
  /* step in the conversion process */
  step_number: Boolean,
  /* 0 is add and 1 is multiply */
  operation: Boolean,
  /* number used in the operation */
  value: Float,
  /* created_at */
  created_at: DateTime,
  /* updated_at */
  updated_at: DateTime)
  
