package io.swagger.client.model




case class Permission (
  /* Grant permission to target user or public so they may access measurements within the given parameters. TODO: Rename target to something more intuitive. */
  target: Integer,
  /* ORIGINAL Variable name */
  variableName: String,
  /* Earliest time when measurements will be accessible in epoch seconds */
  min_timestamp: Integer,
  /* Latest time when measurements will be accessible in epoch seconds */
  max_timestamp: Integer,
  /* Earliest time of day when measurements will be accessible in epoch seconds */
  min_time_of_day: Integer,
  /* Latest time of day when measurements will be accessible in epoch seconds */
  max_time_of_day: Integer,
  /* Maybe specifies if only weekday measurements should be accessible */
  week: String)
  
