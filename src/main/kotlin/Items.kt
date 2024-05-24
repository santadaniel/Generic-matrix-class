class IntItem(data: Int) : Item<Int>(data) {
    override fun plus(increment: Item<Int>) = IntItem(data + increment.data)
    override fun minus(decrement: Item<Int>) = IntItem(data - decrement.data)
    override fun times(multiplicand: Item<Int>) = IntItem(data * multiplicand.data)
}

class FloatItem(data: Float) : Item<Float>(data) {
    override fun plus(increment: Item<Float>) = FloatItem(data + increment.data)
    override fun minus(decrement: Item<Float>) = FloatItem(data - decrement.data)
    override fun times(multiplicand: Item<Float>) = FloatItem(data * multiplicand.data)
}

class DoubleItem(data: Double) : Item<Double>(data) {
    override fun plus(increment: Item<Double>) = DoubleItem(data + increment.data)
    override fun minus(decrement: Item<Double>) = DoubleItem(data - decrement.data)
    override fun times(multiplicand: Item<Double>) = DoubleItem(data * multiplicand.data)
}

class StringItem(data: String) : Item<String>(data) {
    override fun plus(increment: Item<String>) = StringItem(data + increment.data)
    override fun minus(decrement: Item<String>) = if (data.contains(decrement.data)) StringItem("") else StringItem(data)
    override fun times(multiplicand: Item<String>) :Item<String> {
        val builder = StringBuilder()
        for (i in 1..multiplicand.data.length)
            builder.append(data)
        return StringItem(builder.toString())
    }
}