package GeneticAlgorithm.Selection

import GeneticAlgorithm.Individual

import scala.annotation.tailrec
import scala.util.Random

object RouletteWheelSelection {
  def GetIndividual(individuals: Vector[Individual], roll: Double): Individual =
    @tailrec
    def recGetIndividual(remainingIndividuals: List[(Double, Individual)], remainingRoll: Double): Individual =
      val (individualSlice, nextIndividual) = remainingIndividuals.head
      val nextRoll = remainingRoll - individualSlice
      if nextRoll <= 0 then
        nextIndividual
      else
        recGetIndividual(remainingIndividuals.tail, nextRoll)

    val totalFitness =
      individuals
        .map(_.Fitness)
        .sum
    val individualSlices =
      individuals
        .map(individual => (individual.Fitness / totalFitness, individual))
        .toList
    recGetIndividual(individualSlices, roll)

  def Select(individuals: Vector[Individual]): Individual =
    GetIndividual(individuals, Random.nextDouble())
}