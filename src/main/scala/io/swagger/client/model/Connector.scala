package io.swagger.client.model

import org.joda.time.DateTime



case class Connector (
  /* Connector ID number */
  id: Integer,
  /* Lowercase system name for the data source */
  name: String,
  /* Pretty display name for the data source */
  display_name: String,
  /* URL to the image of the connector logo */
  image: String,
  /* URL to a site where one can get this device or application */
  get_it_url: String,
  /* Short description of the service (such as the categories it tracks) */
  short_description: String,
  /* Longer paragraph description of the data provider */
  long_description: String,
  /* Set to 1 if the connector should be returned when listing connectors */
  enabled: Boolean,
  /* Set to 1 if the connector uses OAuth authentication as opposed to username/password */
  oauth: Boolean,
  /* When the record was first created. Use ISO 8601 datetime format */
  created_at: DateTime,
  /* When the record in the database was last updated. Use ISO 8601 datetime format */
  updated_at: DateTime)
  
