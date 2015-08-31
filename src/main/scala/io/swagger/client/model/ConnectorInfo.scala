package io.swagger.client.model




case class ConnectorInfo (
  /* Connector ID number */
  id: Integer,
  /* True if the authenticated user has this connector enabled */
  connected: Boolean,
  /* Error message. Empty if connected. */
  error: String,
  history: List[ConnectorInfoHistoryItem])
  
