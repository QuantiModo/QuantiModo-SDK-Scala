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
  /* When the record was first created. Use ISO 8601 datetime format */
  created_at: DateTime,
  /* When the record in the database was last updated. Use ISO 8601 datetime format */
  updated_at: DateTime)
  
