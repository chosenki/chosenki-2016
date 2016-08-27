import React from 'react'
import FilterLink from '../containers/FilterLink'

const Footer = () => (
  <p>
    展示:
    {" "}
    <FilterLink filter="SHOW_ALL">
      全部
    </FilterLink>
    {", "}
    <FilterLink filter="SHOW_ACTIVE">
      活跃的
    </FilterLink>
    {", "}
    <FilterLink filter="SHOW_COMPLETED">
      已完成的
    </FilterLink>
  </p>
)

export default Footer
