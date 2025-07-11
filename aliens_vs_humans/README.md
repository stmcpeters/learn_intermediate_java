# 👽 Aliens vs. Humans – Java Project Plan (with TDD)

## 📌 Overview

You're building a small Java-based game world where **Humans** and **Aliens** share common traits but also have unique behaviors. These characters will interact in a simulated environment. The entire project will be built using **Test-Driven Development (TDD)**.

---

## 🧠 Project Goal

- Build an inheritance-based system:
  - `Entity` is the superclass.
  - `Human` and `Alien` are subclasses with unique behaviors.
- Create an `Environment` where they interact.
- Use **TDD** for all code.
- Keep code modular, testable, and easy to expand.

---

## 🛠️ TDD Cycle (Red → Green → Refactor)

| Step        | Description |
|-------------|-------------|
| 🔴 Red      | Write a **failing test** first. |
| 🟢 Green    | Write the **smallest amount of code** to pass the test. |
| ♻️ Refactor | Improve the code without changing its behavior. |

Always follow this cycle when creating any new behavior.

---

## 📁 Phase 1: Design Your Class Structure

### 🔹 Decide on Traits

**Shared Traits (for Entity):**
- `name`
- `hp` (health)
- `attack`
- `takeDamage()`
- `getName()`, `getHp()`, etc.

**Unique to Humans:**
- `armor`
- `eat()`
- special skills

**Unique to Aliens:**
- `regeneration`
- `mutation`
- alien race types

---

## 🧪 Phase 2: Build `Entity` with TDD

### Tasks:
1. Write test for:
   - constructor (name, hp, attack)
   - taking damage
2. Let tests fail (Red)
3. Create the `Entity` class to make tests pass (Green)
4. Refactor if needed

### Test Examples:
- Instantiating an `Entity`
- Getting name, hp, attack values
- Taking damage and reducing hp

---

## 👤 Phase 3: Build `Human` with TDD

### Tasks:
1. Write tests for:
   - constructor (name, hp, attack, armor)
   - taking damage (with armor reducing it)
2. Follow the Red → Green → Refactor cycle

### Special Behavior:
- Override `takeDamage()` to reduce damage by `armor`
- Add any unique Human actions later (e.g., `eat()`)

---

## 👽 Phase 4: Build `Alien` with TDD

### Tasks:
1. Write tests for:
   - regeneration behavior
   - healing doesn't exceed max HP
2. Use Red → Green → Refactor to build out functionality

### Special Behavior:
- `regenerate()` method
- Track `maxHp` and `regenRate`
- Potential mutation abilities

---

## 🌍 Phase 5: Build `Environment` with TDD

### Tasks:
1. Decide how to store entities (e.g. ArrayList)
2. Write tests for:
   - adding/removing entities
   - running a `battle()` between two entities
   - checking state after interaction
3. Implement and refactor

### Optional Features:
- Use a 2D grid or create a `Cell` class
- Track entity locations and distances
- Enable special interactions like range-based damage

---

## 🧱 Phase 6: Optional Complexity (Advanced)

Add these only if core logic is working:

- `Cell` class to support grid-based environments
- Items/weapons with slots in each Cell
- Entity/item interactions
- Range/distance logic for attacks

---

## ✅ Phase 7: Final Test + Cleanup

### Tasks:
1. Write integration-style tests:
   - Simulate a human and alien battling
   - Multiple actions in one environment
2. Use `@Before` and `@After` in test files for setup/teardown
3. Refactor:
   - Remove unused code
   - Improve naming and organization
   - Document public methods if needed

---

## 🔁 TDD Reminders

- **Write a test before writing any logic**
- **Only write enough code to make the test pass**
- **Refactor only after tests are green**
- **Small, focused tests > big bloated ones**
- **Use separate test files for each class**

---

## 🧠 Summary of Class Relationships

```text
        Entity
        /    \
     Human   Alien
        \    /
     Environment
