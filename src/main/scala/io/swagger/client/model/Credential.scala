package io.swagger.client.model

import org.joda.time.DateTime



case class Credential (
  /* ID of user that owns this credential */
  user_id: Integer,
  /* The id for the connector data source from which the credential was obtained */
  connector_id: Integer,
  /* Attribute name such as token, userid, username, or password */
  attr_key: String,
  /* Encrypted value for the attribute specified */
  attr_value: String,
  /* When the record was first created. Use ISO 8601 datetime format */
  created_at: DateTime,
  /* When the record in the database was last updated. Use ISO 8601 datetime format */
  updated_at: DateTime)
  
