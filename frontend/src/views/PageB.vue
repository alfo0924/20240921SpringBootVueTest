<template>
  <div class="page-b">
    <h1>Page B</h1>
    <button @click="goToPageA">Go to Page A</button>
    <button @click="goToPageC">Go to Page C</button>
  </div>
</template>

<script>
export default {
  name: 'PageB',
  methods: {
    goToPageA() {
      this.$router.push('/a')
    },
    goToPageC() {
      this.$router.push('/c')
    }
  }
}
</script>

<style scoped>
button {
  margin: 10px;
  padding: 10px;
  background-color: #4CAF50;
  color: white;
  border: none;
  cursor: pointer;
}
</style>
