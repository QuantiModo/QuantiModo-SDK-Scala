package io.swagger.client.model

import org.joda.time.DateTime



case class VariableUserSource (
  /* ID of User */
  user_id: Integer,
  /* ID of variable */
  variable_id: Integer,
  /* ID of source */
  source_id: Integer,
  /* Time that this measurement occurred Uses epoch minute (epoch time divided by 60) */
  timestamp: Integer,
  /* Earliest measurement time */
  earliest_measurement_time: Integer,
  /* Latest measurement time */
  latest_measurement_time: Integer,
  /* created_at */
  created_at: DateTime,
  /* updated_at */
  updated_at: DateTime)
  
