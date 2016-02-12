package io.swagger.client.model

import org.joda.time.DateTime



case class Connection (
  /* id */
  id: Integer,
  /* ID of user that owns this correlation */
  user_id: Integer,
  /* The id for the connector data source for which the connection is connected */
  connector_id: Integer,
  /* Indicates whether a connector is currently connected to a service for a user. */
  connect_status: String,
  /* Error message if there is a problem with authorizing this connection. */
  connect_error: String,
  /* Time at which an update was requested by a user. */
  update_requested_at: DateTime,
  /* Indicates whether a connector is currently updated. */
  update_status: String,
  /* Indicates if there was an error during the update. */
  update_error: String,
  /* The time at which the connector was last successfully updated. */
  last_successful_updated_at: DateTime,
  /* When the record was first created. Use ISO 8601 datetime format */
  created_at: DateTime,
  /* When the record in the database was last updated. Use ISO 8601 datetime format */
  updated_at: DateTime)
  
