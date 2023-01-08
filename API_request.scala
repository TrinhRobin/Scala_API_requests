
object SimpleApp extends App {

/* Testing the tutorial*/
/*GET Method*/ 
val r = requests.get("https://api.github.com/users/lihaoyi")

println(aMethod(aField))
println(r.statusCode)
println(r.headers("content-type"))
println(r.text)*/

/* POST method */
val request_post = requests.post("http://httpbin.org/post", data = Map("first_key" -> request_open_weather_paris.toString))
println(request_post.statusCode)
/* Put method*/ 
val request_put = requests.put("http://httpbin.org/put", data = Map("secound_key" -> request_open_weather_london.toString))
println(request_put.statusCode)


/* OS write for saving json file*/
/*https://github.com/com-lihaoyi/os-lib#oswrite*/
/* Streaming Requests : streaming uploads/downloads without needing to load the entire request/response into memory.  */ 
os.write(
  os.pwd / "file.json",
  requests.get.stream("https://api.github.com/events")
)

ujson.read(requests.get.stream("https://api.github.com/events"))

/*  chain requests together, taking the data returned from one HTTP request and feeding it into another*/ 
os.write(
  os.pwd / "chained.json",
  requests.post.stream(
    "https://httpbin.org/post",
    data = requests.get.stream("https://api.github.com/events")
  )
)

/* Using openwather_map Ap*/
val cities=List("paris", "london", "washington")
/* GET method*/
val request_open_weather_paris =  requests.get(s"https://api.openweathermap.org/data/2.5/weather?q=${cities(0)}&appid=${your_api_key}")
val request_open_weather_london =  requests.get(s"https://api.openweathermap.org/data/2.5/weather?q=${cities(1)}&appid=${your_api_key}")

println(request_open_weather_paris.statusCode)
println(request_open_weather_paris.headers("content-type"))
println(request_open_weather_paris.text)

 /* Spooncular Recipes APi*/ 
val test_api_food = requests.get(s"https://api.spoonacular.com/recipes/complexSearch?apiKey=${your_api_key}&query=pasta&maxFat=25&number=2")
println(test_api_food.statusCode)
println(test_api_food.headers("content-type"))
println(test_api_food.text)

os.write(
  os.pwd / "api_food_items.json",
  requests.get.stream(s"https://api.spoonacular.com/food/menuItems/search?apiKey=${your_api_key}&query=egg&number=3")
)
/* Comparable products*/
os.write(
  os.pwd / "api_food_comparable_items.json",
  requests.get.stream(s"shttps://api.spoonacular.com/food/products/upc/015000071356/comparable?apiKey=${your_api_key}")
)

/* Nation API*/
val test_api_nation= requests.get(s"https://api.nationalize.io?name=${name}")
println(test_api_nation.statusCode)
println(test_api_nation.text)


val test_api_nation2= requests.get(s"https://api.nationalize.io/?name[]=${name}&name[]=${name}&name[]=${name}&name[]=${name}&name[]=${name}")
println(test_api_nation2.statusCode)
println(test_api_nation2.text)

os.write(
  os.pwd / "result_api_nation.json",
  requests.get.stream(s"https://api.nationalize.io/?name[]=${name}&name[]=${name}&name[]=${name}&name[]=${name}&name[]=${name}&name[]=${name}")
)

val test_api_gender= requests.get(s"https://api.genderize.io/?name[]=${name}&name[]=${name}&name[]=${name}")
println(test_api_gender.statusCode)
println(test_api_gender.text)

val test_api_gender2= requests.get(s"https://api.genderize.io?name=${name}&country_id=${country_ISO}")
println(test_api_gender2.statusCode)
println(test_api_gender2.text)


val test_api_gender2_2= requests.get(s"https://api.genderize.io?name=${name}&country_id=${country_ISO}")
println(test_api_gender2_2.statusCode)
println(test_api_gender2_2.text)

val test_api_gender2_3= requests.get(s"https://api.genderize.io?name=${name}&country_id=${country_ISO}")
println(test_api_gender2_3.statusCode)
println(test_api_gender2_3.text)


os.write(
  os.pwd / "result_api_gender.json",
  requests.get.stream(s"https://api.genderize.io?name=Aizen&country_id=JP")
)
os.write(
  os.pwd / "result_api_gender2.json",
  requests.get.stream(s"https://api.genderize.io?name=${name}&country_id=${country_ISO}")
)

}