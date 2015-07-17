class TestSpec extends spock.lang.Specification {
	def "First spock test"() {
		given:
		def x = "myFirstTest1"
		when:
		def y = x.replace("1", "")
		then:
		y == "myFirstTest"
	}
}