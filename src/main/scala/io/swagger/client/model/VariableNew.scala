package io.swagger.client.model




case class VariableNew (
  /* User-defined variable display name. */
  name: String,
  /* Variable category like Mood, Sleep, Physical Activity, Treatment, Symptom, etc. */
  category: String,
  /* Abbreviated name of the default unit for the variable */
  unit: String,
  /* How to aggregate measurements over time. */
  combinationOperation: String,
  /* Parent */
  parent: String)
  
