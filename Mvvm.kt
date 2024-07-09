@Composable
fun Counter(counterViewModel: CounterViewModel = viewModel()) {
    val count by counterViewModel.count.observeAsState(0)
    Column(modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = "Count is $count")
        Button(onClick = { counterViewModel.increment() }) {
            Text(text = "Increment")
        }
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = { counterViewModel.decrement() }) {
            Text(text = "Decrement")
        }
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = { counterViewModel.reset() }) {
            Text(text = "Reset")
        }
    }
}
data class Counter(val count: Int)

class CounterViewModel : ViewModel() {
    private val _counter = mutableStateOf(Counter(count = 0))

    val counter: State<Counter> = _counter

    fun increment() {
        _counter.value = Counter(count = _counter.value.count + 1)
    }

    fun decrement() {
        _counter.value = Counter(count = _counter.value.count - 1)
    }

    fun reset() {
        counter.value = Counter(count = 0)
    }
}

