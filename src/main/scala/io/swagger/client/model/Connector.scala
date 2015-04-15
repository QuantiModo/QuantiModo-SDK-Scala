package io.swagger.client.model




case class Connector (
  /* Connector ID number */
  id: Integer,
  /* Connector lowercase system name */
  name: String,
  /* Connector pretty display name */
  displayName: String,
  /* URL to the image of the connector logo */
  image: String,
  /* URL to a site where one can get this device or application */
  getItUrl: String,
  /* True if the authenticated user has this connector enabled */
  connected: String,
  /* URL and parameters used when connecting to a service */
  connectInstructions: String,
  /* Epoch timestamp of last sync */
  lastUpdate: Integer,
  /* Number of measurements obtained during latest update */
  latestData: Integer,
  /* True if user has no measurements for this connector */
  noDataYet: Boolean)
  
