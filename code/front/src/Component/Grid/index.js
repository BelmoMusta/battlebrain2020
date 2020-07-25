import React from "react";
import PropTypes from "prop-types";
import MIGrid from "@material-ui/core/Grid";

/**
 * Composant Grid
 * @namespace Grid
 * @memberof src.components
 */

const Grid = React.forwardRef(({ spacing, justify, className, children, ...props },ref) => {
	const isContainer = props.container;
	if (isContainer) {
		return (
			<MIGrid
				ref={ref}
				justify={justify}
				spacing={spacing}
				{...props}
				className={
					`${className} ${(justify === "flex-end" ? "co-grid co-grid--flex-end" : "co-grid")}`
				}
			>
				{children}
			</MIGrid>
		);
	}
	return (
		<MIGrid {...props} className={`${className} co-grid`}>
			{children}
		</MIGrid>
	);
});

/**
 * @memberof src.components.Grid
 * @prop {bool} container - Conteneur qui enveloppe les elements grid de type item .
 * @prop {string} justify - L'alignement horizontal des éléments du container. Les valeurs possibles: flex-start, center, flex-end...
 * @prop {number} spacing - Définit l'espace entre le composant de type item. Il ne peut être utilisé que sur un composant de type container. .
 * @prop {string} className - le className du Grid .
 */

Grid.defaultProps = {
	spacing: 4,
	className: "",
	container: false
};
Grid.propTypes = {
	container: PropTypes.bool,
	spacing: PropTypes.any,
	className: PropTypes.string
};

Grid.displayName = "Grid";
export default Grid;
