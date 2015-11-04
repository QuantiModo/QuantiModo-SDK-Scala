package io.swagger.client.model

import org.joda.time.DateTime



case class Update (
  /* id */
  id: Integer,
  /* user_id */
  user_id: Integer,
  /* connector_id */
  connector_id: Integer,
  /* number_of_measurements */
  number_of_measurements: Integer,
  /* success */
  success: Boolean,
  /* message */
  message: String,
  /* created_at */
  created_at: DateTime,
  /* updated_at */
  updated_at: DateTime)
  
