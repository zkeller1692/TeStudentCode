import Vue from 'vue'
import Vuex from 'vuex'

Vue.use(Vuex)

export default new Vuex.Store({
  state: {
    planets: ['Mercury', 'Venus', 'Earth', 'Mars', 'Gas Giants']
  },
  mutations: {
    PLACE_ON_TOP(state, index) {
      let planetToMove = state.planets[index];
      state.planets.splice(index, 1);
      state.planets.unshift(planetToMove);
    },
    ADD_PLANET(state, planet) {
      state.planets.unshift(planet);
    }
  },
  actions: {
  },
  modules: {
  }
})
