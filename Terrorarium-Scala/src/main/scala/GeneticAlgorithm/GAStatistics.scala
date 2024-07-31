package GeneticAlgorithm

case class GAStatistics(MinFitness: Double, MaxFitness: Double, AvgFitness: Double, MedianFitness: Double)

object GAStatistics {
  def Generate(population: Vector[Individual]): GAStatistics =
    val popSize = population.length
    val fitnesses =
      population
        .map(_.Fitness)
        .sortBy(x => x)

    val minFit = fitnesses(0)
    val maxFit = fitnesses(popSize - 1)
    val avgFit = fitnesses.sum / popSize
    val medFit =
      if popSize % 2 == 0 then
        (fitnesses(popSize / 2 - 1) + fitnesses(popSize / 2)) / 2.0
      else
        fitnesses(popSize / 2)

    GAStatistics(minFit, maxFit, avgFit, medFit)
}
