package io.swagger.client.model

import org.joda.time.DateTime



case class Connection (
  /* id */
  id: Integer,
  /* user_id */
  user_id: Integer,
  /* connector_id */
  connector_id: Integer,
  /* connect_status */
  connect_status: String,
  /* connect_error */
  connect_error: String,
  /* update_requested_at */
  update_requested_at: DateTime,
  /* update_status */
  update_status: String,
  /* update_error */
  update_error: String,
  /* last_successful_updated_at */
  last_successful_updated_at: DateTime,
  /* created_at */
  created_at: DateTime,
  /* updated_at */
  updated_at: DateTime)
  
