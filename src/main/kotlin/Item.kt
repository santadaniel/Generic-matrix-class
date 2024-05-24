abstract class Item<T>(val data: T) {
    abstract operator fun plus(increment: Item<T>): Item<T>
    abstract operator fun minus(decrement: Item<T>): Item<T>
    abstract operator fun times(multiplicand: Item<T>): Item<T>
}