<h1>JUnit project</h1>
<p>Reference to: <a href='https://www.udemy.com/course/junit5-for-beginners'>Practical Java Unit Testing with JUnit
    5</a></p>
<h1>JUnit4 vs Junit5 project</h1>
<table>
    <tr>
        <th>JUnit4</th>
        <th>JUnit5</th>
    </tr>
    <tr>
        <td>@Before</td>
        <td>@BeforeEach</td>
    </tr>
    <tr>
        <td>@After</td>
        <td>@AfterEach</td>
    </tr>
    <tr>
        <td>@BeforeClass</td>
        <td>@BeforeAll</td>
    </tr>
    <tr>
        <td>@AfterClass</td>
        <td>@AfterAll</td>
    </tr>
    <tr>
        <td>@Ignore</td>
        <td>@Disabled</td>
    </tr>
    <tr>
        <td>none</td>
        <td>@Nested</td>
    </tr>
    <tr>
        <td>none</td>
        <td>@RepeatedTest</td>
    </tr>
    <tr>
        <td>@Test(expected = Exception.class)</td>
        <td>assertThrows(Exception.class, () -> { ... });</td>
    </tr>
    <tr>
        <td>@Test(timeout = 1)</td>
        <td>assertTimeout(Duration.ofMillis(1), () -> { ... });</td>
    </tr>
</table>
