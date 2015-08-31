package io.swagger.client.model




case class ConnectorInfoHistoryItem (
  /* Number of measurements */
  number_of_measurements: Integer,
  /* True if the update was successfull */
  success: Boolean,
  /* Error message. */
  message: String,
  /* Date and time of the update */
  created_at: String)
  
