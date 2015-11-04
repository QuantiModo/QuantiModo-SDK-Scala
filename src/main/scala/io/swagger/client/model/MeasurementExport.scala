package io.swagger.client.model

import org.joda.time.DateTime



case class MeasurementExport (
  /* id */
  id: Integer,
  /* ID of User */
  user_id: Integer,
  /* Status of Measurement Export */
  status: String,
  /* Error message */
  error_message: String,
  /* created_at */
  created_at: DateTime,
  /* updated_at */
  updated_at: DateTime)
  
