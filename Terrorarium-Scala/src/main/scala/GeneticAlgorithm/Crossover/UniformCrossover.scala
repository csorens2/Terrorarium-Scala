package GeneticAlgorithm.Crossover

import GeneticAlgorithm._

import scala.util.Random

object UniformCrossover {
  def PerformCrossover(parentA: Chromosome, parentB: Chromosome, crossoverChoices: LazyList[Boolean]): Chromosome =
    if parentA.Genes.length != parentB.Genes.length then
      throw new IllegalArgumentException("Parent chromosomes not the same length")
    else
      val childGenes =
        parentA.Genes
          .zip(parentB.Genes)
          .zip(crossoverChoices)
          .map((genes, choice) =>
            if choice then
              genes._1
            else
              genes._2)
      Chromosome(childGenes)

  def Crossover(parentA: Chromosome, parentB: Chromosome): Chromosome =
    def infBoolList(): LazyList[Boolean] =
      Random.nextBoolean() #:: infBoolList()

    PerformCrossover(parentA, parentB, infBoolList())
}